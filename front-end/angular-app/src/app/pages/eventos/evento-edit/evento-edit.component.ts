import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { EventoService } from '../evento.service';

@Component({
  selector: 'app-evento-update',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './evento-edit.component.html',
  styleUrls: ['./evento-edit.component.css']
})
export class EventoEditComponent implements OnInit {

  evento: any = {};
  id!: number;

  constructor(
    private service: EventoService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {

    this.id = Number(this.route.snapshot.paramMap.get('id'));

    this.service.buscarPorId(this.id).subscribe(data => {
      this.evento = data;
    });
  }

  atualizar() {
    this.service.atualizar(this.id, this.evento).subscribe(() => {

      alert('Evento atualizado com sucesso! 📅');

      this.router.navigate(['/eventos']);
    });
  }
}