import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes} from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PrincipalComponent } from './components/principal/principal.component';

import { RUTAS } from './app.routes';
import { InicioComponent } from './components/inicio/inicio.component';
import { LoginComponent } from './components/login/login.component';
import { RegistrosComponent } from './components/registros/registros.component';
import { CerrarSesionComponent } from './components/cerrar-sesion/cerrar-sesion.component';
import { EditarPerfilComponent } from './components/editar-perfil/editar-perfil.component';

@NgModule({
  declarations: [
    AppComponent,
    PrincipalComponent,
    InicioComponent,
    LoginComponent,
    RegistrosComponent,
    CerrarSesionComponent,
    EditarPerfilComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(RUTAS, { useHash:true }),
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
