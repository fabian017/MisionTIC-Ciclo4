import { Routes } from '@angular/router';
import { PrincipalComponent } from  './components/principal/principal.component'
import { InicioComponent } from  './components/inicio/inicio.component'
export const RUTAS : Routes =[
    {path: 'principal', component: PrincipalComponent },
    { path: 'inicio', component: InicioComponent },
    {path: '',pathMatch: 'full', redirectTo: 'principal'},
    {path: '**', pathMatch: 'full', redirectTo: 'principal'}
];