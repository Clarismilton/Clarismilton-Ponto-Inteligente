INSERT INTO `empresa` (`id`, `cnpj`, `data_atualizacao`, `data_criacao`, `razao_social`) 
VALUES (NULL, '82198127000121', CURRENT_DATE(), CURRENT_DATE(), 'Clarismilton IT');

INSERT INTO `funcionario` (`id`, `cpf`, `data_atualizacao`, `data_criacao`, `email`, `nome`, 
`perfil`, `qtd_horas_almoco`, `qtd_horas_trabalho_dia`, `senha`, `valor_hora`, `empresa_id`) 
VALUES (NULL, '37481410259', CURRENT_DATE(), CURRENT_DATE(), 'clarismilton@gmail.com', 'ADMIN', 'ROLE_ADMIN', NULL, NULL, 
'$2a$10$GZ1VAagBGxret5ae0iBR8u5BZG7xTNHimXhFhiCv5yZbzbkVg9BTi', NULL, 
(SELECT `id` FROM `empresa` WHERE `cnpj` = '82198127000121'));