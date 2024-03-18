import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'adharno',
})
export class AdharnoPipe implements PipeTransform {
  transform(value: string, ...args: string[]): unknown {
    let delim: string = args[0];
    console.log('value: ' + value);
    console.log('Delimeter: ' + delim);

    let first: string = value.toString().substr(0, 4);
    let second: string = value.toString().substr(4, 4);
    let third: string = value.toString().substr(8, 4);

    return first + delim + second + delim + third;
  }
}
