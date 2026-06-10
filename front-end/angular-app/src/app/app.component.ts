import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Nav } from "./pages/nav/nav";

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.html',
  styleUrl: './app.css',
  imports: [RouterOutlet, Nav]
})
export class AppComponent {
menuAberto: any;
}