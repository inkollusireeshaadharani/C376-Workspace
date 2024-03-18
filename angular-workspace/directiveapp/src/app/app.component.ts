import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'directiveapp';
  employees = ['Tom', 'Jerry', 'Donald', 'Mickey', 'Mini'];
  myPwd = 'password';
  /*
  Component is a special type of Directive.
  3 types of Directives are - 1. Component, Structural, and Attribute
  Structural Directives manipulate/change appearance of DOM dynamically
  Add * before structural directives
  ngFor is structural directive
  
  Attribute Directives add Cosmetics to the Element. They are used to change the appearance or behavior of an element, component, or another directive.
   * is no more required
  ngClass is an attribute directive

  
  */
}
