import { NgModule } from '@angular/core';
import { Title } from '@angular/platform-browser';

import {
    Jhipsterstateless0921SharedLibsModule,
    JhiAlertComponent,
    JhiAlertErrorComponent
} from './';

@NgModule({
    imports: [
        Jhipsterstateless0921SharedLibsModule
    ],
    declarations: [
        JhiAlertComponent,
        JhiAlertErrorComponent
    ],
    providers: [
        Title
    ],
    exports: [
        Jhipsterstateless0921SharedLibsModule,
        JhiAlertComponent,
        JhiAlertErrorComponent
    ]
})
export class Jhipsterstateless0921SharedCommonModule {}
