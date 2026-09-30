import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ListaJogos } from './componentes/lista-jogos/lista-jogos';
import { FormularioJogo } from './componentes/formulario-jogo/formulario-jogo';
import { Jogo } from './modelos/jogo';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ListaJogos, FormularioJogo],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  title = signal('biblioteca-jogos-front');
  jogoEmEdicao?: Jogo;
}
