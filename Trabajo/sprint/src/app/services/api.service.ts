import { Injectable } from '@angular/core';
import { HttpClient, HttpHandler, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { SesionService } from './sesion.service';
import { Usuario } from '../Interfaces/usuarios.interface';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  url:string = "http://localhost:8080/"

  constructor(private httpClient:HttpClient, private sesionService:SesionService) { }

  login(usuario:string, password:string){
    const peticion = `${this.url}usuarios/login`;
    const username:any = {
      usuario,
      password
    };
    const headers:HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/json;charset="utf-8"'
    })
    return this.httpClient.post(peticion, username, {headers})
                          .pipe(map((data:any)=>{
                            return data;
                          }))
  }

  /*Ver Usuario en plataforma*/
  getUsuarios(){
    const peticion = `${this.url}usuarios`;

    const headers:HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/json;charset="utf-8"',
      'Authorization': 'Bearer '+this.sesionService.getUsuario().token
    })

    return this.httpClient.get(peticion,{ headers }).pipe(map((data:any)=>{
      return data;
    }));
  }

  getUsuario(id:number){
    const peticion = `${this.url}usuarios/${id}`;

    const headers:HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/json;charset="utf-8"',
      'Authorization': 'Bearer '+this.sesionService.getUsuario().token
    })

    return this.httpClient.get(peticion,{ headers }).pipe(map((data:any)=>{
      return data;
    }));
  }
   /*Actualizar Usuario en plataforma*/
  updateUsuario(usuario:any){
    const peticion = `${this.url}usuarios`;

    const headers:HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/json;charset="utf-8"',
      'Authorization': 'Bearer '+this.sesionService.getUsuario().token
    })

    return this.httpClient.put(peticion, usuario, { headers })
                          .pipe(map((data:any)=>{
                            return data;
                          }))
  }

   /*Registrar Usuario en plataforma*/
    addUsuario(user:any){
    const peticion = `${this.url}usuarios/registrar`;
    /*const user:any = {
      nombre,
      apellido,
      fechaNacimiento,
      edad,
      signoZodiaco,
      idiomaNativo,
      idiomaAprender,
      usuario,
      password,
      tipoDeCliente,
      tipoUsuario
    };*/
    const headers:HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/json;charset="utf-8"'
    })

    return this.httpClient.post(peticion, user,{headers})
                           .pipe(map((data:any)=>{
                              return data;
                           }));

  }

}
