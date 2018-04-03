import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrianglestypeComponent } from './trianglestype.component';

describe('TrianglestypeComponent', () => {
  let component: TrianglestypeComponent;
  let fixture: ComponentFixture<TrianglestypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrianglestypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrianglestypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
