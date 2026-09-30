import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Jogo } from '../modelos/jogo';

@Injectable({ providedIn: 'root' })
export class JogoService {
  private url = 'http://localhost:8080/jogos';
  constructor(private http: HttpClient) {}

  listarTodos(): Observable<Jogo[]> { return this.http.get<Jogo[]>(this.url); }
  buscarPorId(id: number): Observable<Jogo> { return this.http.get<Jogo>(`${this.url}/${id}`); }
  criar(jogo: Jogo): Observable<Jogo> { return this.http.post<Jogo>(this.url, jogo); }
  atualizar(id: number, jogo: Jogo): Observable<Jogo> { return this.http.put<Jogo>(`${this.url}/${id}`, jogo); }
  deletar(id: number): Observable<void> { return this.http.delete<void>(`${this.url}/${id}`); }
}
