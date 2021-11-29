import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../services/api.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SesionService } from 'src/app/services/sesion.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  formulario:FormGroup;
  error:boolean=false;
  constructor(private apiService:ApiService, private router:Router, private formBuilder:FormBuilder, private sesionService:SesionService) {
    this.formulario = this.formBuilder.group({
      usuario : ['', Validators.required],
      password : ['', Validators.required]
    })
  }

  ngOnInit(): void {
  }

  get usuarioNoValido(){
    return this.formulario.get('usuario')?.invalid && this.formulario.get('usuario')?.touched;
  }

  get passwordNoValido(){
    return this.formulario.get('password')?.invalid && this.formulario.get('password')?.touched;
  }

  verificarDatos():any{
    console.log("hola");
    if(this.formulario.invalid){
      Object.values(this.formulario.controls).forEach(control=>{
        control.markAsTouched();
      })
      return;
    }
    this.error = false;
    let usuario = {
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

    this.apiService.login(this.formulario.value.usuario, this.formulario.value.password).subscribe((response)=>{
      
      usuario = JSON.parse(JSON.stringify(response));
      
      if(usuario.id==null){
        this.error = true;
      }else{
        if(Number.isInteger(usuario.id)){
          this.error = false;

          this.sesionService.setUsuario(usuario);

          console.log(usuario)
          this.router.navigate(['/principal']);
        }else{
          this.error = true;
        }
      }
    })
  }

}
