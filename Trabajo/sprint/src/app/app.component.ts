import { Component } from '@angular/core';
import { Usuario } from './Interfaces/usuarios.interface';
import { SesionService } from './services/sesion.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'sprint';
  usuario:Usuario;
  
  constructor(public sesionService:SesionService){
    this.usuario = this.sesionService.getUsuario();
  }
}
