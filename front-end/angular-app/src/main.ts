import { bootstrapApplication } from '@angular/platform-browser';
import { provideRouter } from '@angular/router';
import { App } from './app/app';

import { EventoListComponent } from './app/pages/eventos/evento-list/evento-list.component';
import { Home } from './app/pages/Home';
import { provideHttpClient } from '@angular/common/http';
import { EventoCreateComponent } from './app/pages/eventos/evento-create/evento-create.component';
import { EventoEditComponent } from './app/pages/eventos/evento-edit/evento-edit.component';

bootstrapApplication(App, {
  providers: [
    provideRouter([
      { path: '', component: Home },
      { path: 'eventos', component: EventoListComponent },
      { path: 'eventos/novo', component: EventoCreateComponent },
      { path: 'eventos/editar/:id', component: EventoEditComponent },
    ]),
    provideHttpClient()
  ]
});