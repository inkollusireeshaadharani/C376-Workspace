import { Component } from '@angular/core';
import { User } from '../user';

@Component({
  selector: 'app-templatedrivenform',
  templateUrl: './templatedrivenform.component.html',
  styleUrls: ['./templatedrivenform.component.css'],
})
export class TemplatedrivenformComponent {
  topics = ['Angular', 'React', 'Vue'];
  title = 'Template Driven Form';
  userModel = new User(
    'amitd',
    'amitd2001@gmail.com',
    '9850980543',
    '',
    'morning'
  );
  constructor() {}
  ngOnInit(): void {}

  onSubmit() {
    // console.log(
    //   "in template driven's onSubmit " +
    //     this.userModel.email +
    //     this.userModel.topic
    // );
    alert(JSON.stringify(this.userModel));
  }
}

/*
   Template Driven Form
   1. Code and Logic resides in HTML template
   2. Easy to use and similar to Angular 1 Forms
   3. 2 way bindings is used. ngModel directive
   4. Bulky HTML code and minimal component code      5. It is suitable for simple forms */

/*
  One needs to import FormsModule
  along with ngModel directive, name attribute is necessary
  In TDF when it comes to data binding, there are 3 directives 
     ngForm, ngModel and ngModelGroup 
*/
/*
   control has been visited : ng-touched or ng-untouched
   control's value has changed : ng-dirty or ng-pristine
   control's value is valid : ng-valid or ng-invalid
 */
/*  In Reactive Forms, we require ReactiveFormsModule thus add it in app.module.ts
    FormGroup and FormControl classes are used
    Each form field (from html like username, password and confirmpassword) are
    considered as instances of FormControl.
    Entire form comprising of 3 form fields is defined as an instance of FormGroup */
    