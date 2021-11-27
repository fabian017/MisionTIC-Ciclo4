import { Routes } from '@angular/router';
import { PrincipalComponent } from  './components/principal/principal.component'
import { InicioComponent } from  './components/inicio/inicio.component'
import { LoginComponent } from './components/login/login.component';
export const RUTAS : Routes =[
    {path: 'principal', component: PrincipalComponent },
    {path: 'inicio', component: InicioComponent },
    {path: 'login', component: LoginComponent },
    {path: '',pathMatch: 'full', redirectTo: 'inicio'},
    {path: '**', pathMatch: 'full', redirectTo: 'inicio'}
];