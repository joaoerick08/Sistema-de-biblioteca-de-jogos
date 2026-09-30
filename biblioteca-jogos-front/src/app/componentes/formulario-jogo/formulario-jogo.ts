import { Component, Input, Output, EventEmitter, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { JogoService } from '../../servicos/jogo';
import { EstudioService } from '../../servicos/estudio';
import { Jogo } from '../../modelos/jogo';
import { Estudio } from '../../modelos/estudio';

const COR_PADRAO = '#7a3b2e';

const JOGO_VAZIO: Jogo = {
  nome: '',
  anoLancamento: 2024,
  pontuacao: 0,
  avaliacaoPessoal: 0,
  corLombada: COR_PADRAO,
  estudio: { id: 0 },
  categorias: []
};

@Component({
  selector: 'app-formulario-jogo',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './formulario-jogo.html',
  styleUrl: './formulario-jogo.css'
})
export class FormularioJogo implements OnInit {
  jogo: Jogo = { ...JOGO_VAZIO };
  estudios = signal<Estudio[]>([]);

  mostrarNovoEstudio = false;
  novoEstudio: Estudio = { nome: '', pais: '' };

  @Input() set jogoParaEditar(jogo: Jogo | undefined) {
    if (jogo) this.jogo = { ...jogo, corLombada: jogo.corLombada ?? COR_PADRAO };
  }

  @Output() jogoSalvo = new EventEmitter<void>();

  constructor(private jogoService: JogoService, private estudioService: EstudioService) {}

  ngOnInit(): void {
    this.carregarEstudios();
  }

  carregarEstudios(): void {
    this.estudioService.listarTodos().subscribe(dados => {
      this.estudios.set(dados);
      if (!this.jogo.estudio.id && dados.length > 0) {
        this.jogo.estudio = { id: dados[0].id! };
      }
    });
  }

  salvarNovoEstudio(): void {
    if (!this.novoEstudio.nome.trim()) return;
    this.estudioService.criar(this.novoEstudio).subscribe(criado => {
      this.carregarEstudios();
      this.jogo.estudio = { id: criado.id! };
      this.novoEstudio = { nome: '', pais: '' };
      this.mostrarNovoEstudio = false;
    });
  }

  salvar(): void {
    if (this.jogo.id) {
      this.jogoService.atualizar(this.jogo.id, this.jogo).subscribe(() => {
        this.finalizarSalvamento();
      });
    } else {
      this.jogoService.criar(this.jogo).subscribe(() => {
        this.finalizarSalvamento();
      });
    }
  }

  private finalizarSalvamento(): void {
    const estudioAtual = this.jogo.estudio;
    this.jogo = { ...JOGO_VAZIO, estudio: estudioAtual };
    this.jogoSalvo.emit();
  }
}
