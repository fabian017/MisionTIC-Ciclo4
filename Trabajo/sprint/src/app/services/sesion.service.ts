import { Injectable } from '@angular/core';
import { Usuario } from '../Interfaces/usuarios.interface';
@Injectable({
  providedIn: 'root'
})
export class SesionService {

  private usuario: Usuario= {
    id: 0,
      nombre: '',
      apellido: '',
      fechaNacimiento: '',
      edad: 0,
      signoZodiaco: '',
      idiomaNativo: '',
      idiomaAprender: '',
      usuario: '',
      password: '',
      token: ''
  };

  getUsuario():Usuario{
    return this.usuario;
  }

  setUsuario(usuario: Usuario):void{
    this.usuario = usuario;
    this.guardarStorage();
    
  }

  resetUsuario():void{
    this.usuario = {
      id: 0,
      nombre: '',
      apellido: '',
      fechaNacimiento: '',
      edad: 0,
      signoZodiaco: '',
      idiomaNativo: '',
      idiomaAprender: '',
      usuario: '',
      password: '',
      token: ''
    }
    this.guardarStorage();
  }

  constructor() { 
    this.leerStorage();
  }

  guardarStorage():void{
    sessionStorage.setItem("usuario", JSON.stringify(this.usuario));
  }

  leerStorage():void{
    if(sessionStorage.getItem("usuario")){
      let datos = sessionStorage.getItem("usuario");
      this.usuario = JSON.parse(JSON.stringify(datos));
    }
  }

}
