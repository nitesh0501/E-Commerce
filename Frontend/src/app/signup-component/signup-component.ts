import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Service } from '../service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup-component',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './signup-component.html',
  styleUrls: ['./signup-component.css'],  
})
export class SignupComponent {

  signUpDetails = {
    fName: '',
    lName: '',
    email: '',
    password: ''
  };

  constructor(private service: Service,private router:Router) { }

  onSubmit(form: NgForm) {
    this.service.onSignUp(this.signUpDetails).subscribe({
      next: (response:any) => {
        console.log("Signup success", response);

      
        this.signUpDetails = {
          fName: '',
          lName: '',
          email: '',
          password: ''
        };

        
        form.reset();
        this.router.navigate(['/login']);
      },
      error: (err:any) => {
        console.error('Signup failed:', err);
      }
    });
  }
}
