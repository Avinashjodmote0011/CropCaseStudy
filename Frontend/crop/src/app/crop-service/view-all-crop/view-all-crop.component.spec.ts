import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAllCropComponent } from './view-all-crop.component';

describe('ViewAllCropComponent', () => {
  let component: ViewAllCropComponent;
  let fixture: ComponentFixture<ViewAllCropComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewAllCropComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewAllCropComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
