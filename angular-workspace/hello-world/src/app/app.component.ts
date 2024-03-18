import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: ` <h1>{{ myTitle }}</h1>`,
  styles: [
    `
      h1 {
        color: #369;
      }
    `,
  ],
})
export class AppComponent {
  /*
The constructor() should only be used to initialize class members but shouldn't do actual 
“work”. So, we should use constructor() to setup Dependency Injection, Initialization 
of class fields etc. ngOnInit() is a better place to write “actual work code” that we 
need to execute as soon as the class is instantiated.
*/

  public constructor() {
    console.log('inside the constructor');
  }
  /*
  ngOnInit is a lifecycle hook in Angular that is called after the constructor is 
  called and after the component's inputs have been initialized. It is used to 
  perform any additional initialization that is required for the component. 
  ngOnInit is commonly used to call services or to set up subscriptions.
  */
  ngOnInit() {
    console.log('inside the ngOnInit');
  }
  myTitle = 'My First Angular';
}
// ng serve
// 	–ng will look at the file  angular.json to find the entry point to our app
// 	–angular.json specifies a "main" file, which in this case is main.ts
// 	–main.ts is the entry-point for our app and it bootstraps our application
// 	–The bootstrap process boots an Angular module(“AppModule”)
// 	–We use the AppModule to bootstrap the app. AppModule is specified in src/app/app.module.ts
// 	–AppModules specifies which component to use as the top-level component. Here it is AppComponent
// 	–AppComponent has <app-root> tags in the template and this renders output.
