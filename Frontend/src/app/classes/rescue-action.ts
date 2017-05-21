export class RescueAction {
  id: Number = 0;
  naziv: String = '';
  opis: String = '';
  vrijeme: Date = new Date;
  potraga: String = '0';
  fazaZivotnogCiklusa: Number = 1;
  voditeljNaziv: String = '';
  voditeljId: String = '';
  vrstaSpasavanjaId: Number = 1;
  latitude: Number = 44.5281298;
  longitude: Number = 15.2061534;
  nazivLokacije: String = '';
  radius: Number = 100;
  rescueType: Number = 1;
}
