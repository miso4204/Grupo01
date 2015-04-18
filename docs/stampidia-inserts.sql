
INSERT INTO smtp_plan VALUES (2, 'Startup', 'Plan intermedio: Startup', true);
INSERT INTO smtp_plan VALUES (1, 'Rookie', 'Plan básico: Rookie', true);
INSERT INTO smtp_plan VALUES (3, 'Business', 'Plan completo: Business', true);

INSERT INTO stmp_category VALUES (1, 'Geek', 'Geek', true);
INSERT INTO stmp_category VALUES (2, 'Funny', 'Funny', true);
INSERT INTO stmp_category VALUES (3, 'Love', 'Love', true);
INSERT INTO stmp_category VALUES (4, 'Sports ', 'Sports', true);
INSERT INTO stmp_category VALUES (5, 'Animals', 'Animals', true);

INSERT INTO stmp_color VALUES (1, 'Black', '000000', true);
INSERT INTO stmp_color VALUES (2, 'Blue', '0000FF', true);
INSERT INTO stmp_color VALUES (3, 'Red', 'FF0000', true);
INSERT INTO stmp_color VALUES (4, 'Green', '008000', true);
INSERT INTO stmp_color VALUES (5, 'Yellow', 'FFFF00', true);


INSERT INTO stmp_payment_type VALUES (1, 'CoD', 'Cash on Delivery', 'cash_success', 'cash_error', true);
INSERT INTO stmp_payment_type VALUES (3, 'CREDIT CARD', 'Credit Card', 'credit_success', 'credit_error', true);
INSERT INTO stmp_payment_type VALUES (2, 'PSE', 'PSE', 'pse_success', 'pse_error ', true);

INSERT INTO stmp_shipping_type VALUES (1, 'CoD', 'Cash on Delivery', true);


INSERT INTO stmp_size VALUES (1, 'S', true);
INSERT INTO stmp_size VALUES (2, 'M', true);
INSERT INTO stmp_size VALUES (3, 'L', true);
INSERT INTO stmp_size VALUES (4, 'XL', true);
INSERT INTO stmp_size VALUES (5, 'XXL', true);

INSERT INTO stmp_user VALUES (2, 'diego', 'diego', 'die-agud@uniandes.edu.co', NULL, NULL, false, NULL, true);
INSERT INTO stmp_user VALUES (1, 'lore', 'lore', 'tachu.salamanca@gmail.com', 'probabas@hotmail.com ', 'probabas@hotmail.com', true, 1, true);

INSERT INTO stmp_stamp VALUES (1, 'Bitchachos', 'Adios Bitchachos', 'http://image19.spreadshirtmedia.com/image-server/v1/compositions/111665151/views/1,width=235,height=235,appearanceId=1/Adios-Bitchachos-T-Shirts.jpg         ', 'mustache', 1, 0, 2, 10, true);
INSERT INTO stmp_stamp VALUES (2, 'Big Guns Black Backing', 'Big Guns Black Backing  ', 'http://image1.spreadshirtmedia.com/image-server/v1/compositions/109073810/views/1,width=235,height=235,appearanceId=66/Big-Guns-Black-Backing-T-Shirts.jpg   ', 'dinosaur', 1, 0, 5, 10, true);
INSERT INTO stmp_stamp VALUES (4, 'Downloading', 'Downloading', 'http://image14.spreadshirtmedia.com/image-server/v1/compositions/101760412/views/1,width=235,height=235,appearanceId=4/Downloading---poop-t-shirt.jpg        ', 'toilet  ', 1, 0, 2, 10, true);
INSERT INTO stmp_stamp VALUES (5, 'I''m Right', 'I''m Right ', 'http://image8.spreadshirtmedia.com/image-server/v1/compositions/101951577/views/1,width=235,height=235,appearanceId=2/I-m-Not-Arguing-T-Shirts.jpg           ', 'arguing ', 1, 0, 1, 12, true);
INSERT INTO stmp_stamp VALUES (6, 'We have pi!', 'We have pi!', 'http://image12.spreadshirtmedia.com/image-server/v1/compositions/103394848/views/1,width=235,height=235,appearanceId=196/Come-to-the-dork-side.jpg           ', 'pi      ', 1, 0, 1, 10, true);
INSERT INTO stmp_stamp VALUES (7, 'Baby cone', 'Baby cone ', 'http://image19.spreadshirtmedia.com/image-server/v1/compositions/16119746/views/1,width=235,height=235,appearanceId=1/Ice-Cream-Maternity-Tshirt.jpg         ', 'baby    ', 1, 0, 3, 10, true);
INSERT INTO stmp_stamp VALUES (8, 'Pretty Princess', 'Pretty Princess', 'http://image6.spreadshirtmedia.com/image-server/v1/compositions/1005489586/views/1,width=235,height=235,appearanceId=386/Pretty-Princess-T-shirt.jpg         ', 'princess', 1, 0, 3, 15, true);
INSERT INTO stmp_stamp VALUES (9, 'Love   ', 'Baseball Love', 'http://image3.spreadshirtmedia.com/image-server/v1/compositions/105285613/views/1,width=235,height=235,appearanceId=348/Love-Baseball.jpg    ', 'baseball', 1, 0, 4, 10, true);
INSERT INTO stmp_stamp VALUES (10, 'Split Happens', 'Split Happens', 'http://image1.spreadshirtmedia.com/image-server/v1/compositions/111195605/views/1,width=235,height=235,appearanceId=231/Split-Happens.jpg    ', 'bowling ', 1, 0, 4, 12, true);
INSERT INTO stmp_stamp VALUES (11, 'Eat crayons, poop rainbows', 'Eat crayons, poop rainbows  ', 'http://image6.spreadshirtmedia.com/image-server/v1/compositions/111499333/views/1,width=235,height=235,appearanceId=99/Rainbow-poop-pug-T-Shirts.jpg         ', 'dog     ', 1, 0, 5, 12, true);
INSERT INTO stmp_stamp VALUES (3, 'Hipster Cat', 'Hipster Cat', 'http://image17.spreadshirtmedia.com/image-server/v1/compositions/1001777446/views/1,width=235,height=235,appearanceId=5/Hipster-Kitten-Baby-Cat-with-Glasses--T-Shirts.jpg     ', 'hipster ', 1, 0, 5, 15, true);

INSERT INTO stmp_stamp_rating VALUES (1, 5, 'love it ', 3, 2);
INSERT INTO stmp_stamp_rating VALUES (2, 4, 'awesome ', 5, 2);

INSERT INTO stmp_shirt_style VALUES (2, 'V-Neck', 'V-Neck', 7, false);
INSERT INTO stmp_shirt_style VALUES (1, 'Round Neck', 'Round Neck', 5, true);

INSERT INTO stmp_shirt VALUES (1, 1, 1, NULL, 1, 0, 1, 1);
INSERT INTO stmp_shirt VALUES (2, 3, 4, NULL, 1, 0, 1, 8);
INSERT INTO stmp_shirt VALUES (3, 3, 2, NULL, 2, 0, 1, 7);
INSERT INTO stmp_shirt VALUES (4, 2, 3, 'Meh', 1, 0, 1, 9);
INSERT INTO stmp_shirt VALUES (5, 1, 1, NULL, 1, 0, 1, 3);

INSERT INTO stmp_shirt_rating VALUES (1, 3, 'pretty', 1, 2);
INSERT INTO stmp_shirt_rating VALUES (2, 4, 'cool', 2, 2);


INSERT INTO stmp_order VALUES (1, 2, 3, 1, '2015-04-06', true, true, true, 3);
INSERT INTO stmp_order_detail VALUES (1, 1, 1, 1, 1);






