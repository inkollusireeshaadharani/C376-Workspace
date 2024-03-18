import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { NewsComponent } from './news/news.component';
import { FinancenewsComp } from './news/financenews';
import { SportsnewsComp } from './news/sportsnews';
import { EquitynewsComp } from './news/equitynews';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { ProductComponent } from './product/product.component';

const route1: Routes = [
  { path: 'about', component: AboutComponent },
  {
    path: 'news',
    component: NewsComponent,
    children: [
      { path: 'news/sports', component: SportsnewsComp },
      { path: 'news/finance', component: FinancenewsComp },
      { path: 'news/equity', component: EquitynewsComp },
    ],
  },
  { path: 'prod', component: ProductComponent },
  { path: 'selectedprod/:nam', component: ProductDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(route1)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
