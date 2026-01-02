import { Component } from '@angular/core';
import { FormsModule, NgForm } from "@angular/forms";
import { Service } from '../service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-component',
  standalone:true,
  imports: [FormsModule],
  templateUrl: './login-component.html',
  styleUrls: ['./login-component.css'],
})
export class LoginComponent {

  loginDetails={
    email:'',
    password:''
  }

  constructor(private service: Service, private router: Router){}

  onSubmit(form: NgForm){
      console.log(this.loginDetails);
      this.service.loginUser(this.loginDetails).subscribe({
        next: (res:any) => {
          console.log("login Success", res);
          alert("Log in Successful");
          form.reset();
          this.router.navigate(['/product'])
        },
        error: (err:any) => {
          console.log("login Failed", err);
          alert("Something went wrong");
        }
      });
  }
}
