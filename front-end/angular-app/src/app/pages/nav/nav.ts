import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-nav',
  standalone: true,
  imports: [CommonModule, RouterModule], 
  templateUrl: './nav.html',
  styleUrls: ['./nav.css'] // 👈 corrigi aqui também
})
export class Nav {

  menuAberto = false;
  eventosAberto = false;
  usuariosAberto = false;

  toggleMenu() {
    this.menuAberto = !this.menuAberto;
  }

  toggleEventos() {
    this.eventosAberto = !this.eventosAberto;
    this.usuariosAberto = false; // melhoria
  }

  toggleUsuarios() {
    this.usuariosAberto = !this.usuariosAberto;
    this.eventosAberto = false; // melhoria
  }
}