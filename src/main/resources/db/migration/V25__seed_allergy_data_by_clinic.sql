-- 4. Create allergy question list per clinic
INSERT INTO allergy_question (id, clinic_id, description)
SELECT 'e0e7ae03-c566-4fff-8576-7c6eb7a173fe',
 'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
 '1. Jeni duke vizituar ndonjë mjek në dy vitet e fundit? Nëse po, për cfar arsye?'
WHERE NOT EXISTS (SELECT 1 FROM allergy_question WHERE  id = 'e0e7ae03-c566-4fff-8576-7c6eb7a173fe');


INSERT INTO allergy_question (id, clinic_id, description)
SELECT '4a6be7bc-0897-4533-82f4-c47ac57d7daa',
 'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
 '2. Shkruaj emrin e mjekut juaj te besuar.'
WHERE NOT EXISTS (SELECT 1 FROM allergy_question WHERE  id = '4a6be7bc-0897-4533-82f4-c47ac57d7daa');


INSERT INTO allergy_question (id, clinic_id, description)
SELECT '0630c32a-4a57-4631-9e84-b8188ccd3f53',
 'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
 '3. Jeni shtruar në spital apo keni bërë ndërhyrje kirurgjikale? Nëse po, për cfar?'
WHERE NOT EXISTS (SELECT 1 FROM allergy_question WHERE  id = '0630c32a-4a57-4631-9e84-b8188ccd3f53');


INSERT INTO allergy_question (id, clinic_id, description)
SELECT '5461e27b-d662-4e11-b9df-f52c7a8f4afb',
 'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
 '4. Përdorni shpesh apo rrallë ilace?'
WHERE NOT EXISTS (SELECT 1 FROM allergy_question WHERE  id = '5461e27b-d662-4e11-b9df-f52c7a8f4afb');


INSERT INTO allergy_question (id, clinic_id, description)
SELECT '4fde1fbe-9c13-4507-8422-7fb83734feff',
 'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
 '5. Jeni alergjik nga ndonjë supstancë? Nëse po, emrin e ilacit, llojin e reaksionit?'
WHERE NOT EXISTS (SELECT 1 FROM allergy_question WHERE  id = '4fde1fbe-9c13-4507-8422-7fb83734feff');

INSERT INTO allergy_question (id, clinic_id, description)
SELECT '65a20a0a-f6f5-41ad-b0a9-fd6094699dae',
 'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
 '6. Keni patur reagime të padëshiruara gjatë anastezisë dentare? Nëse po, cfar reagimi?'
WHERE NOT EXISTS (SELECT 1 FROM allergy_question WHERE  id = '65a20a0a-f6f5-41ad-b0a9-fd6094699dae');

INSERT INTO allergy_question (id, clinic_id, description)
SELECT '378bf0e3-5330-4ffd-b2ed-b51895312d72',
 'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
 '7. Keni sëmundje zemre apo tensioni të lartë?'
WHERE NOT EXISTS (SELECT 1 FROM allergy_question WHERE  id = '378bf0e3-5330-4ffd-b2ed-b51895312d72');

INSERT INTO allergy_question (id, clinic_id, description)
SELECT 'c132fb4f-1612-4b61-b0b3-42ab1ab67932',
 'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
 '8. Keni sëmundje pulmonare apo turbukuloz?'
WHERE NOT EXISTS (SELECT 1 FROM allergy_question WHERE  id = 'c132fb4f-1612-4b61-b0b3-42ab1ab67932');

INSERT INTO allergy_question (id, clinic_id, description)
SELECT 'd0745e3f-10b0-465f-b5b8-d58bfdfa8e88',
 'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
 '9. Keni sëmundje veshkash?'
WHERE NOT EXISTS (SELECT 1 FROM allergy_question WHERE  id = 'd0745e3f-10b0-465f-b5b8-d58bfdfa8e88');

INSERT INTO allergy_question (id, clinic_id, description)
SELECT '36011d35-12be-4434-b8d3-993983da1300',
 'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
 '10. Jeni diabetik?'
WHERE NOT EXISTS (SELECT 1 FROM allergy_question WHERE  id = '36011d35-12be-4434-b8d3-993983da1300');

INSERT INTO allergy_question (id, clinic_id, description)
SELECT '7ba476d8-2149-495c-ab9a-c1049ba1ba10',
 'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
 '11. Keni probleme me koagulumin e gjakut apo anemine?'
WHERE NOT EXISTS (SELECT 1 FROM allergy_question WHERE  id = '7ba476d8-2149-495c-ab9a-c1049ba1ba10');

INSERT INTO allergy_question (id, clinic_id, description)
SELECT 'dc2b33c3-8759-451a-b617-e35be53c70cd',
 'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
 '12. Keni hepatite apo probleme me melcinë?'
WHERE NOT EXISTS (SELECT 1 FROM allergy_question WHERE  id = 'dc2b33c3-8759-451a-b617-e35be53c70cd');

INSERT INTO allergy_question (id, clinic_id, description)
SELECT '300fad98-257d-48c1-8f1c-0b92025e1e57',
 'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
 '13. (Për femrat) Jeni shtatëzane?'
WHERE NOT EXISTS (SELECT 1 FROM allergy_question WHERE  id = '300fad98-257d-48c1-8f1c-0b92025e1e57');

INSERT INTO allergy_question (id, clinic_id, description)
SELECT '61102621-a88e-4fea-aabd-55b8b6bafc2f',
 'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
 '14. Keni patur ndonje sëmundje tjetër që nuk është përmendur më sipër? Nëse po, cfarë?'
WHERE NOT EXISTS (SELECT 1 FROM allergy_question WHERE  id = '61102621-a88e-4fea-aabd-55b8b6bafc2f');

-- Testing clinics --

INSERT INTO allergy_question (id, clinic_id, description)
SELECT 'a075b506-ff99-45e8-af73-1329b3547ba0',
 '55116308-d862-4d15-83d1-062db5934fc5',
 '1. Jeni duke vizituar ndonjë mjek në dy vitet e fundit? Nëse po, për cfar arsye?'
WHERE NOT EXISTS (SELECT 1 FROM allergy_question WHERE  id = 'a075b506-ff99-45e8-af73-1329b3547ba0');


INSERT INTO allergy_question (id, clinic_id, description)
SELECT 'beb3a6fd-4325-4791-b4a2-f65f246d498f',
 '55116308-d862-4d15-83d1-062db5934fc5',
 '2. Shkruaj emrin e mjekut juaj te besuar.'
WHERE NOT EXISTS (SELECT 1 FROM allergy_question WHERE  id = 'beb3a6fd-4325-4791-b4a2-f65f246d498f');


INSERT INTO allergy_question (id, clinic_id, description)
SELECT '8d77d9b5-f827-4d99-af38-ed4a1b3326ee',
 '55116308-d862-4d15-83d1-062db5934fc5',
 '3. Jeni shtruar në spital apo keni bërë ndërhyrje kirurgjikale? Nëse po, për cfar?'
WHERE NOT EXISTS (SELECT 1 FROM allergy_question WHERE  id = '8d77d9b5-f827-4d99-af38-ed4a1b3326ee');


-- Testing clinics --

INSERT INTO allergy_question (id, clinic_id, description)
SELECT 'ee21bf2e-5924-44bb-9599-bdb27a09a084',
 '18086732-c546-478f-bb42-a1ecf1a8cd6b',
 '1. Jeni duke vizituar ndonjë mjek në dy vitet e fundit? Nëse po, për cfar arsye?'
WHERE NOT EXISTS (SELECT 1 FROM allergy_question WHERE  id = 'ee21bf2e-5924-44bb-9599-bdb27a09a084');


INSERT INTO allergy_question (id, clinic_id, description)
SELECT '8e0abc19-d68c-4141-98d6-9d49d70802c1',
 '18086732-c546-478f-bb42-a1ecf1a8cd6b',
 '2. Shkruaj emrin e mjekut juaj te besuar.'
WHERE NOT EXISTS (SELECT 1 FROM allergy_question WHERE  id = '8e0abc19-d68c-4141-98d6-9d49d70802c1');
