import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Estudio } from '../modelos/estudio';

@Injectable({ providedIn: 'root' })
export class EstudioService {
  private url = 'http://localhost:8080/estudios';
  constructor(private http: HttpClient) {}

  listarTodos(): Observable<Estudio[]> { return this.http.get<Estudio[]>(this.url); }
  criar(estudio: Estudio): Observable<Estudio> { return this.http.post<Estudio>(this.url, estudio); }
}
