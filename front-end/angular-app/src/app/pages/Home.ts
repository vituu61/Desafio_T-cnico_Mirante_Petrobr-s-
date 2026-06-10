import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  standalone: true,
  template: `
    <div style="padding: 20px;">
      <h2>Bem-vindo ao sistema 🚀</h2>
      <p>Selecione uma opção no menu.</p>
    </div>
  `
})
export class Home {}