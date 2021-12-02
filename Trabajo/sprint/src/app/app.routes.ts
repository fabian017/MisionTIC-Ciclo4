import { Routes } from '@angular/router';
import { PrincipalComponent } from  './components/principal/principal.component'
import { InicioComponent } from  './components/inicio/inicio.component'
import { LoginComponent } from './components/login/login.component';
import { CerrarSesionComponent } from './components/cerrar-sesion/cerrar-sesion.component';
import { EditarPerfilComponent } from './components/editar-perfil/editar-perfil.component';
import { RegistroComponent } from './components/registro/registro.component';
export const RUTAS : Routes =[
    {path: 'principal', component: PrincipalComponent },
    {path: 'inicio', component: InicioComponent },
    {path: 'registro', component: RegistroComponent },
    {path: 'login', component: LoginComponent },
    {path: 'cerrar-sesion', component: CerrarSesionComponent },
    {path: 'editar-perfil/:id', component: EditarPerfilComponent },
    {path: '',pathMatch: 'full', component: InicioComponent},
    {path: '**', pathMatch: 'full', redirectTo: 'inicio'}
];