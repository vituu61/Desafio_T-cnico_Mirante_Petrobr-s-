import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { EventoService } from '../evento.service';

@Component({
  selector: 'app-evento-create',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './evento-create.component.html',
  styleUrls: ['./evento-create.component.css']
})
export class EventoCreateComponent {

  evento: any = {
    titulo: '',
    descricao: '',
    local: '',
    dataEvento: ''
  };

  constructor(private service: EventoService) {}

salvar() {

  const payload = {
    ...this.evento,
    dataEvento: this.evento.dataEvento
      ? new Date(this.evento.dataEvento).toISOString().slice(0, 19)
      : null
  };

  console.log('Payload enviado:', payload);

  this.service.salvar(payload).subscribe(() => {
    alert('Evento cadastrado com sucesso! 📅');

    this.evento = {
      titulo: '',
      descricao: '',
      local: '',
      dataEvento: ''
    };
  });
}}