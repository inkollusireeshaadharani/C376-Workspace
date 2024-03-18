// import { Directive } from '@angular/core';
import { Directive, ElementRef, HostListener } from '@angular/core';
@Directive({
  selector: '[mydirective]',
})
export class CustomhoverDirective {
  constructor(private el: ElementRef) {}
  @HostListener('mouseenter')
  onMouseEnter() {
    this.focusColor('green');
  }
  @HostListener('mouseleave')
  onMouseLeave() {
    this.focusColor('yellow');
  }
  public focusColor(color: any) {
    this.el.nativeElement.style.backgroundColor = color;
  }
}
//needs to declare in app.module.ts. All components and directives need to declare in declaratios section of app.module.ts
//import it in app.module.ts and at that time give classname and relative path
//Via Constructor, Dependenncy Injection is achieved.
//ElementRef is injected in case of custom Attribute Directive
//TemplateRef and ViewContainerRef are injected in case of custom Structural Attribute Directive
//TemplateRef for accessing the Dom contents and ViewContainerRef for performing manipulations
