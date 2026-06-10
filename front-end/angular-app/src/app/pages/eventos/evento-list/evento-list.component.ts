import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { EventoService } from '../evento.service';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';



@Component({
  selector: 'app-evento-list',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './evento-list.component.html',
  styleUrls: ['./evento-list.component.css'],


})
export class EventoListComponent implements OnInit {


  eventos: any[] = [];


  constructor(private service: EventoService, private router: Router) { }


  ngOnInit() {
    this.service.listar().subscribe(data => {
      this.eventos = data;
    });
  }

  paginaAtual = 1;
  itensPorPagina = 5;

  get eventosPaginados() {
    const inicio = (this.paginaAtual - 1) * this.itensPorPagina;
    const fim = inicio + this.itensPorPagina;
    return this.eventosFiltrados.slice(inicio, fim);
  }

  editar(id: number) {
    this.router.navigate(['/eventos/editar', id]);
  }

  deletar(id: number) {
    const confirmacao = confirm('Tem certeza que deseja excluir este evento?');

    if (confirmacao) {
      this.service.deletar(id).subscribe(() => {

        this.eventos = this.eventos.filter(evento => evento.id !== id);

        alert('Evento excluído com sucesso! 🗑️');
      });
    }
  }


  filtro: string = '';
  get eventosFiltrados() {
    const termo = this.filtro?.toLowerCase() || '';

    return this.eventos.filter(evento =>
      evento.titulo.toLowerCase().includes(termo) ||
      evento.descricao.toLowerCase().includes(termo) ||
      evento.local.toLowerCase().includes(termo)  
    );
  }

}