import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginFrom:FormGroup;
  loading=false;
  submitted=false;
  returnUrl:string;
  constructor(
    private formBuilder:FormBuilder,private route:ActivatedRoute,private router:Router,
    private authenticationService:Authentication/////

  ) { }

  ngOnInit(): void {
  }

}
