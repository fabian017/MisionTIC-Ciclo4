import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../services/api.service';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SesionService } from 'src/app/services/sesion.service';
import { ThrowStmt } from '@angular/compiler';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']

})
export class RegistroComponent implements OnInit {
  formulario: FormGroup;
  perfil:any={};
  error:boolean = false;
  ingresado:boolean = false;

  constructor(private formBuilder:FormBuilder, private apiService:ApiService, private sesionService:SesionService) {
    this.formulario = this.formBuilder.group({
      nombre:['', Validators.required],
      apellido:['', Validators.required],
      fechaNacimiento:['', Validators.required],
      edad:['', Validators.required],
      signoZodiaco:['', Validators.required],
      idiomaNativo:['', Validators.required],
      idiomaAprender:['', Validators.required],
      usuario:['', Validators.required],
      password: ['', Validators.required],
      tipoDeCliente: ['', Validators.required],
      tipoUsuario: ['', Validators.required]
    });
    
    this.perfil = {
      "id": 0,
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

    console.log(this.perfil);
    
    

    
  }

  
  ngOnInit(): void {
  }

  get nombreNoValido(){
    return this.formulario.get('nombre')?.invalid && this.formulario.get('nombre')?.touched;
  }

  get apellidoNoValido(){
    return this.formulario.get('apellido')?.invalid && this.formulario.get('apellido')?.touched;
  }

  get fechaNacimientoNoValido(){
    return this.formulario.get('fechaNacimiento')?.invalid && this.formulario.get('fechaNacimiento')?.touched;
  }

  get edadNoValido(){
    return this.formulario.get('edad')?.invalid && this.formulario.get('edad')?.touched;
  }

  get signoZodiacoNoValido(){
    return this.formulario.get('signoZodiaco')?.invalid && this.formulario.get('signoZodiaco')?.touched;
  }

  get idiomaNativoNoValido(){
    return this.formulario.get('idiomaNativo')?.invalid && this.formulario.get('idiomaNativo')?.touched;
  }

  get idiomaAprenderNoValido(){
    return this.formulario.get('idiomaAprender')?.invalid && this.formulario.get('idiomaAprender')?.touched;
  }

  get usuarioNoValido(){
    return this.formulario.get('usuario')?.invalid && this.formulario.get('usuario')?.touched;
  }

  get passwordNoValido(){
    return this.formulario.get('password')?.invalid && this.formulario.get('password')?.touched;
  }

  get tipoDeClienteNoValido(){
    return this.formulario.get('tipoDeCliente')?.invalid && this.formulario.get('tipoDeCliente')?.touched;
  }

  get tipoUsuarioNoValido(){
    return this.formulario.get('tipoUsuario')?.invalid && this.formulario.get('tipoUsuario')?.touched;
  }

 guardarDatos():any{
  if(this.formulario.invalid){
    Object.values(this.formulario.controls).forEach(control=> {
      control.markAsTouched();
    })
    return;
  }
  this.error = false;

  let usuario= {
    id: 0,
    nombre: "",
    apellido: "",
    fechaNacimiento: "",
    edad: 0,
    signoZodiaco: "",
    idiomaNativo: "",
    idiomaAprender: "",
    usuario: "",
    password: "",
    tipoDeCliente: {
        id: 0,
        tipo_string: "",
        precio: 0
    },
    tipoUsuario: {
        id: 0,
        tipo_usuario: ""
    }
  }

  let user={
    id: 0,
    nombre: this.formulario.value.nombre,
    apellido: this.formulario.value.apellido,
    fechaNacimiento: this.formulario.value.fechaNacimiento,
    edad: this.formulario.value.edad,
    signoZodiaco: this.formulario.value.signoZodiaco,
    idiomaNativo: this.formulario.value.idiomaNativo,
    idiomaAprender: this.formulario.value.idiomaAprender,
    usuario: this.formulario.value.usuario,
    password: this.formulario.value.password,
    tipoDeCliente: {
        id: this.formulario.value.tipoDeCliente,
        tipo_string: "",
        precio: 0
    },
    tipoUsuario: {
        id: this.formulario.value.tipoUsuario,
        tipo_usuario: ""
    }
  }

  console.log(user);

  this.apiService.addUsuario(user).subscribe((response)=>{
    usuario = JSON.parse(JSON.stringify(response));

    if(usuario.id=0){
      this.error = true;
    }
    else{
      this.error = false;
      this.ingresado = true;
    }
  })
 }
}

