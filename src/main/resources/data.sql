DROP TABLE IF EXISTS location;

CREATE TABLE location (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  city VARCHAR(250) NOT NULL,
  latitude DOUBLE  NOT NULL,
  longitude DOUBLE  NOT NULL
);

INSERT INTO location (city, latitude, longitude) VALUES ('Bogota', 4.6097100, -74.0817500);
INSERT INTO location (city, latitude, longitude) VALUES ('Medellín',	6.25184, -75.563591);
INSERT INTO location (city, latitude, longitude) VALUES ('Cali',	3.437222,	-76.5225);
INSERT INTO location (city, latitude, longitude) VALUES ('Barranquilla',	10.963889,	-74.796389);
INSERT INTO location (city, latitude, longitude) VALUES ('Bucaramanga',	7.125393,	-73.119804);
INSERT INTO location (city, latitude, longitude) VALUES ('Cartagena',	10.399722,	-75.514444);
INSERT INTO location (city, latitude, longitude) VALUES ('Cúcuta',	7.893907,	-72.507821);
INSERT INTO location (city, latitude, longitude) VALUES ('Soledad',	10.918433,	-74.76459);
INSERT INTO location (city, latitude, longitude) VALUES ('Pereira',	4.813333,	-75.696111);
INSERT INTO location (city, latitude, longitude) VALUES ('Santa Marta',	11.240791,	-74.19904);
INSERT INTO location (city, latitude, longitude) VALUES ('Ibagué',	4.438889,	-75.232222);
INSERT INTO location (city, latitude, longitude) VALUES ('Pasto',	1.213611,	-77.281111);
INSERT INTO location (city, latitude, longitude) VALUES ('Manizales',	5.06889,	-75.517383);
INSERT INTO location (city, latitude, longitude) VALUES ('Villavicencio',	4.142002,	-73.626645);
INSERT INTO location (city, latitude, longitude) VALUES ('Neiva',	2.927299,	-75.281885);
INSERT INTO location (city, latitude, longitude) VALUES ('Armenia',	4.533889,	-75.681111);
INSERT INTO location (city, latitude, longitude) VALUES ('Valledupar',	10.46314,	-73.253224);
INSERT INTO location (city, latitude, longitude) VALUES ('Montería',	8.747984,	-75.881428);
INSERT INTO location (city, latitude, longitude) VALUES ('Sincelejo',	9.304722,	-75.397778);
INSERT INTO location (city, latitude, longitude) VALUES ('Popayán',	2.444444,	-76.613889);
INSERT INTO location (city, latitude, longitude) VALUES ('Buenaventura',	3.880099,	-77.031164);
INSERT INTO location (city, latitude, longitude) VALUES ('Barrancabermeja',	7.065278,	-73.854722);
INSERT INTO location (city, latitude, longitude) VALUES ('Tuluá',	4.084656,	-76.19536);
INSERT INTO location (city, latitude, longitude) VALUES ('Tunja',	5.535278,	-73.367778);
INSERT INTO location (city, latitude, longitude) VALUES ('Cartago',	4.746389,	-75.911667);
INSERT INTO location (city, latitude, longitude) VALUES ('Ríohacha',	11.544444,	-72.907222);
INSERT INTO location (city, latitude, longitude) VALUES ('Ciénaga',	11.007029,	-74.247646);
INSERT INTO location (city, latitude, longitude) VALUES ('Florencia',	1.614382,	-75.606229);
INSERT INTO location (city, latitude, longitude) VALUES ('Girardot',	4.298659,	-74.804681);
INSERT INTO location (city, latitude, longitude) VALUES ('Sogamoso',	5.714344,	-72.933908);
INSERT INTO location (city, latitude, longitude) VALUES ('Pupiales',	0.87136,	-77.640269);
INSERT INTO location (city, latitude, longitude) VALUES ('Duitama',	5.824499,	-73.034083);
INSERT INTO location (city, latitude, longitude) VALUES ('Magangué',	9.242024,	-74.754671);
INSERT INTO location (city, latitude, longitude) VALUES ('Quibdó',	5.694722,	-76.661111);
INSERT INTO location (city, latitude, longitude) VALUES ('Tumaco',	1.798611,	-78.815556);
INSERT INTO location (city, latitude, longitude) VALUES ('Ocaña',	8.237727,	-73.356038);
INSERT INTO location (city, latitude, longitude) VALUES ('Arauca',	7.084512,	-70.755366);
INSERT INTO location (city, latitude, longitude) VALUES ('Sabanalarga',	10.629617,	-74.92063);
INSERT INTO location (city, latitude, longitude) VALUES ('Yopal',	5.337752,	-72.395859);
INSERT INTO location (city, latitude, longitude) VALUES ('El Carmen de Bolívar',	9.717396,	-75.120232);
INSERT INTO location (city, latitude, longitude) VALUES ('Leticia',	-4.215278,	-69.940556);
INSERT INTO location (city, latitude, longitude) VALUES ('San Andrés',	12.584722,	-81.700556);
INSERT INTO location (city, latitude, longitude) VALUES ('Garzón',	2.19593,	-75.627773);
INSERT INTO location (city, latitude, longitude) VALUES ('El Banco',	9.001137,	-73.975807);
INSERT INTO location (city, latitude, longitude) VALUES ('Chiquinquirá',	5.616373,	-73.817484);
INSERT INTO location (city, latitude, longitude) VALUES ('Pamplona',	7.375647,	-72.647949);
INSERT INTO location (city, latitude, longitude) VALUES ('Lorica',	9.236484,	-75.813499);
INSERT INTO location (city, latitude, longitude) VALUES ('Turbo',	8.093678,	-76.726908);
INSERT INTO location (city, latitude, longitude) VALUES ('Arjona',	10.254444,	-75.343889);
INSERT INTO location (city, latitude, longitude) VALUES ('Honda',	5.20856,	-74.735842);
INSERT INTO location (city, latitude, longitude) VALUES ('Yarumal',	7.030278,	-75.590556);
INSERT INTO location (city, latitude, longitude) VALUES ('Puerto Berrío',	6.491565,	-74.403264);
INSERT INTO location (city, latitude, longitude) VALUES ('Túquerres',	1.088776,	-77.618305);
INSERT INTO location (city, latitude, longitude) VALUES ('Tame',	6.460647,	-71.736176);
INSERT INTO location (city, latitude, longitude) VALUES ('Tolú',	9.523919,	-75.581392);
INSERT INTO location (city, latitude, longitude) VALUES ('Socorro',	6.468382,	-73.260224);
INSERT INTO location (city, latitude, longitude) VALUES ('Ayapel',	8.313721,	-75.139822);
INSERT INTO location (city, latitude, longitude) VALUES ('Campoalegre',	2.684892,	-75.323109);
INSERT INTO location (city, latitude, longitude) VALUES ('San José del Guaviare',	2.572858,	-72.645914);
INSERT INTO location (city, latitude, longitude) VALUES ('Mocoa',	1.149327,	-76.64661);
INSERT INTO location (city, latitude, longitude) VALUES ('Sonsón',	5.71062,	-75.310685);
INSERT INTO location (city, latitude, longitude) VALUES ('Puerto López',	4.084514,	-72.955974);
INSERT INTO location (city, latitude, longitude) VALUES ('San Marcos',	3.67274,	-73.656431);
INSERT INTO location (city, latitude, longitude) VALUES ('Guapi',	2.570823,	-77.885421);
INSERT INTO location (city, latitude, longitude) VALUES ('Puerto Carreño',	6.189031,	-67.485879);
INSERT INTO location (city, latitude, longitude) VALUES ('Mitú',	1.257778,	-70.234722);
INSERT INTO location (city, latitude, longitude) VALUES ('Orocué',	4.791175,	-71.335423);
INSERT INTO location (city, latitude, longitude) VALUES ('Nuquí',	5.7125,	-77.270833);
INSERT INTO location (city, latitude, longitude) VALUES ('Juradó',	7.106113,	-77.75794);
INSERT INTO location (city, latitude, longitude) VALUES ('San Vicente del Caguán',	2.121722,	-74.766141);
INSERT INTO location (city, latitude, longitude) VALUES ('Inírida',	3.865278,	-67.923889);