import { Routes } from '@angular/router';

import {InicioComponent} from './componentes/inicio/inicio.component';
import { RegistroComponent } from './componentes/registro/registro.component';

export const RUTAS:Routes = [
    {path: 'inicio', component: InicioComponent },
    {path: 'Registro', component:RegistroComponent},
    
    {path: '', pathMatch: 'full', redirectTo: 'inicio'},
    {path: '**', pathMatch: 'full', redirectTo: 'inicio'}

];
