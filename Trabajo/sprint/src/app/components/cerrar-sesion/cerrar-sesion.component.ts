import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SesionService } from 'src/app/services/sesion.service';

@Component({
  selector: 'app-cerrar-sesion',
  template: ''
})
export class CerrarSesionComponent implements OnInit {

  constructor(private router:Router, private sesionService:SesionService) { 
    this.sesionService.resetUsuario();
    this.router.navigate(['/inicio']);
  }

  ngOnInit(): void {
  }

}
