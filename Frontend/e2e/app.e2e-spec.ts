import { HackathonovoIN2Page } from './app.po';

describe('hackathonovo-in2 App', () => {
  let page: HackathonovoIN2Page;

  beforeEach(() => {
    page = new HackathonovoIN2Page();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
