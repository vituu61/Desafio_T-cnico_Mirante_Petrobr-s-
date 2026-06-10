import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EventoService {

  private api = 'http://localhost:8080/eventos';

  constructor(private http: HttpClient) { }

  listar(): Observable<any[]> {
    return this.http.get<any[]>(this.api);
  }

  salvar(evento: any) {
    return this.http.post(this.api, evento);
  }

  atualizar(id: number, evento: any) {
    return this.http.put(`${this.api}/${id}`, evento);
  }

  deletar(id: number) {
    return this.http.delete(`${this.api}/${id}`);
  }
  buscarPorId(id: number) {
    return this.http.get(`${this.api}/${id}`);
  }
}


