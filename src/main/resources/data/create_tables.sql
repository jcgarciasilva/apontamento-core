DROP TABLE IF EXISTS `Projeto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Projeto` (
  `prjId` bigint(20) NOT NULL AUTO_INCREMENT,
  `prjCodigo` varchar(100) NOT NULL,
  `prjDescricao` varchar(1000) NOT NULL,
  PRIMARY KEY (`prjId`)
);

DROP TABLE IF EXISTS `Parametros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Parametros` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(255) DEFAULT NULL,
  `VALOR` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `Cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cliente` (
  `cliCodigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `cliNome` varchar(50) NOT NULL,
  PRIMARY KEY (`cliCodigo`)
) ;
/*!40101 SET character_set_client = @saved_cs_client */;
DROP TABLE IF EXISTS `Servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Servico` (
  `serCodigo` varchar(1) NOT NULL,
  `serNome` varchar(20) NOT NULL,
  PRIMARY KEY (`serCodigo`)
) ;
/*!40101 SET character_set_client = @saved_cs_client */;
DROP TABLE IF EXISTS `Usuari`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuari` (
  `usrCodigo` varchar(10) NOT NULL,
  `usrDatCri` date DEFAULT NULL,
  `usrMail` varchar(100) NOT NULL,
  `usrNivel` int(11) DEFAULT NULL,
  `usrNome` varchar(30) NOT NULL,
  `usrSenha` varchar(128) DEFAULT NULL,
  `usrSit` varchar(255) NOT NULL,
  PRIMARY KEY (`usrCodigo`)
) ;
/*!40101 SET character_set_client = @saved_cs_client */;