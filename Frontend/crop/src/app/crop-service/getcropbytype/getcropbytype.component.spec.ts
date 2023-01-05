import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetcropbytypeComponent } from './getcropbytype.component';

describe('GetcropbytypeComponent', () => {
  let component: GetcropbytypeComponent;
  let fixture: ComponentFixture<GetcropbytypeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetcropbytypeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetcropbytypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
