// main.ts : Bootstraps the application. It is the first file to be executed
// is the glue that combines the component and page together.
// this is the page the component will be rendered in.
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';

platformBrowserDynamic()
  .bootstrapModule(AppModule)
  .catch((err) => console.error(err));
