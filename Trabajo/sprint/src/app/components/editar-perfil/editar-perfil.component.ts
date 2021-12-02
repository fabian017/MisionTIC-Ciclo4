import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../services/api.service';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SesionService } from 'src/app/services/sesion.service';
import { ThrowStmt } from '@angular/compiler';

@Component({
  selector: 'app-editar-perfil',
  templateUrl: './editar-perfil.component.html',
  styleUrls: ['./editar-perfil.component.css']
})
export class EditarPerfilComponent implements OnInit {

  perfil:any={};
  error:boolean=false;

  constructor(private activatedRoute:ActivatedRoute, private apiService:ApiService, private router:Router, private sesionService:SesionService) {
    this.perfil = {
      "id": this.sesionService.getUsuario().id,
      "nombre": "",
      "apellido": "",
      "fechaNacimiento": "",
      "edad": 0,
      "signoZodiaco": "",
      "idiomaNativo": "",
      "idiomaAprender": "",
      "usuario": "",
      "password": "",
      "tipoDeCliente": {
          "id": 0,
          "tipo_string": "",
          "precio": 0
      },
      "tipoUsuario": {
          "id": 0,
          "tipo_usuario": ""
      }
    }

    this.activatedRoute.params.subscribe(parametros=>{
      let id = parametros["id"];
      this.apiService.getUsuario(id).subscribe((response)=>{
        this.perfil = JSON.parse(JSON.stringify(response));
      })
    })
    
  }

  ngOnInit(): void {
  }

  regresar(){
    this.router.navigate(['/principal']);
  }

  actualizarUsuario(nombre:any, apellido:any, edad:any, idiomaNativo:any, idiomaAprender:any, usuario:any, password:any){
    this.perfil.nombre = nombre;
    this.perfil.apellido = apellido;
    this.perfil.edad = parseInt(edad);
    this.perfil.idiomaNativo = idiomaNativo;
    this.perfil.idiomaAprender = idiomaAprender;
    this.perfil.usuario = usuario;
    this.perfil.password = password;
    this.error = false;
    console.log(this.perfil)

    this.apiService.updateUsuario(this.perfil).subscribe(response=>{
      let respuesta = JSON.parse(JSON.stringify(response));

      this.router.navigate(['/principal']);
    })
  }
  
}
