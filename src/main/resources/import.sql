INSERT INTO tb_user(nome, sobrenome, cpf, telefone, renda) VALUES('Gabriel','Guedes','11111111111','11 95555-2222', 10000);
INSERT INTO tb_user(nome, sobrenome, cpf, telefone, renda) VALUES('Robson','Silva','22222222222','11 95677-7777', 4500);
INSERT INTO tb_user(nome, sobrenome, cpf, telefone, renda) VALUES('Douglas','Pinheiro','33333333333','11 95333-4444', 6450);


INSERT INTO tb_proposta(valor_solicitado, prazo_para_pagamento, aprovado, user_id) VALUES(1000,12,true,1);
INSERT INTO tb_proposta(valor_solicitado, prazo_para_pagamento, aprovado, user_id) VALUES(4000,16,false,1);


INSERT INTO tb_proposta(valor_solicitado, prazo_para_pagamento, aprovado, user_id) VALUES(2000,14,false,2);
INSERT INTO tb_proposta(valor_solicitado, prazo_para_pagamento, aprovado, user_id) VALUES(800,8,false,2);

INSERT INTO tb_proposta(valor_solicitado, prazo_para_pagamento, aprovado, user_id) VALUES(5400,15,true,3);
INSERT INTO tb_proposta(valor_solicitado, prazo_para_pagamento, aprovado, user_id) VALUES(30000,36,false,3);