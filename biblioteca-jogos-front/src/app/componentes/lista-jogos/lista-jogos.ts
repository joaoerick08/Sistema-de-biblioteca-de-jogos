import { Component, OnInit, Output, EventEmitter, signal, computed, NgZone } from '@angular/core';
import { CommonModule } from '@angular/common';
import { JogoService } from '../../servicos/jogo';
import { Jogo } from '../../modelos/jogo';

@Component({
  selector: 'app-lista-jogos',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './lista-jogos.html',
  styleUrl: './lista-jogos.css'
})
export class ListaJogos implements OnInit {
  jogos = signal<Jogo[]>([]);

  estantes = computed(() => {
    const grupos = new Map<string, Jogo[]>();
    for (const jogo of this.jogos()) {
      const nomeEstudio = jogo.estudio?.nome ?? `Estúdio #${jogo.estudio?.id}`;
      if (!grupos.has(nomeEstudio)) grupos.set(nomeEstudio, []);
      grupos.get(nomeEstudio)!.push(jogo);
    }
    return Array.from(grupos.entries()).map(([nome, jogos]) => ({ nome, jogos }));
  });

  @Output() jogoSelecionado = new EventEmitter<Jogo>();

  constructor(private jogoService: JogoService, private zona: NgZone) {}

  ngOnInit(): void {
    this.carregar();
  }

  carregar(): void {
    this.jogoService.listarTodos().subscribe(dados => {
      this.zona.run(() => this.jogos.set(dados));
    });
  }

  editar(jogo: Jogo): void {
    this.jogoSelecionado.emit(jogo);
  }

  deletar(id: number | undefined): void {
    if (!id) return;
    this.jogoService.deletar(id).subscribe(() => {
      this.zona.run(() => this.jogos.update(atual => atual.filter(j => j.id !== id)));
    });
  }
}
