import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/Interfaces/usuarios.interface';
import { ApiService } from 'src/app/services/api.service';
import { SesionService } from '../../services/sesion.service'

@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.css']
})
export class PrincipalComponent implements OnInit {

  perfiles:any[] = [];
  usuario:Usuario;

  constructor(public sesionService:SesionService, private apiService:ApiService) {
    this.usuario = this.sesionService.getUsuario();

    this.apiService.getUsuarios().subscribe((response)=>{
      this.perfiles = JSON.parse(JSON.stringify(response));
      console.log(this.perfiles);
    })

   }

  ngOnInit(): void {
  }

}
