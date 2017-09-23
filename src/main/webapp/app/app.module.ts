import './vendor.ts';

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Ng2Webstorage } from 'ng2-webstorage';

import { Jhipsterstateless0921SharedModule, UserRouteAccessService } from './shared';
import { Jhipsterstateless0921HomeModule } from './home/home.module';
import { Jhipsterstateless0921AdminModule } from './admin/admin.module';
import { Jhipsterstateless0921AccountModule } from './account/account.module';
import { Jhipsterstateless0921EntityModule } from './entities/entity.module';

import { customHttpProvider } from './blocks/interceptor/http.provider';
import { PaginationConfig } from './blocks/config/uib-pagination.config';

import {
    JhiMainComponent,
    LayoutRoutingModule,
    NavbarComponent,
    FooterComponent,
    ProfileService,
    PageRibbonComponent,
    ErrorComponent
} from './layouts';

@NgModule({
    imports: [
        BrowserModule,
        LayoutRoutingModule,
        Ng2Webstorage.forRoot({ prefix: 'jhi', separator: '-'}),
        Jhipsterstateless0921SharedModule,
        Jhipsterstateless0921HomeModule,
        Jhipsterstateless0921AdminModule,
        Jhipsterstateless0921AccountModule,
        Jhipsterstateless0921EntityModule
    ],
    declarations: [
        JhiMainComponent,
        NavbarComponent,
        ErrorComponent,
        PageRibbonComponent,
        FooterComponent
    ],
    providers: [
        ProfileService,
        customHttpProvider(),
        PaginationConfig,
        UserRouteAccessService
    ],
    bootstrap: [ JhiMainComponent ]
})
export class Jhipsterstateless0921AppModule {}
