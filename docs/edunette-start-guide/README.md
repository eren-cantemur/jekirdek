# Edunette Başlangıç Kılavuzu
Local makinenizde edunette uygulamalarını kurup çalıştırmak için yapılması gerekenler.

## Visual Studio

[Bu linkten](https://visualstudio.microsoft.com/tr/) Visual Studio Community sürümünü indirin.
Kurulum sihirbazında ASP.NET and web development ve .NET desktop development seçeneklerini seçin ver kuruluma devam edin.

[Bu linkten](https://dotnet.microsoft.com/en-us/download/dotnet/3.0) .Net Core 3.0 Hosting Bundle'ı indirin ve kurun.

## MS-SQL

[Bu linkten](https://www.microsoft.com/tr-tr/sql-server/sql-server-downloads) MsSQL Developer sürümünü indirip BASIC installation type seçeneğini seçerek kurulumu tamamlayın.

Kurulumun sonunda SSMS indirip kurmanız gerekmekte. [Bu linkten](https://learn.microsoft.com/en-us/sql/ssms/download-sql-server-management-studio-ssms?redirectedfrom=MSDN&view=sql-server-ver16) kurulum sürecini takip edebilirsiniz.

Kurulum bittikten sonra bilgisayarınıza yeni kurduğunuz MS-SQL konfigürasyonlarını yapmalısınız adımlar şu şekilde ->
1. SQL Server 2019 Configuration Manager'ı açın
2. SQL Server Network Configuration altındaki Disabled olan tüm seçenekleri Enabled yapın.
3. Microsoft SQL Server Management Studio üzerinden varsayılan olarak gelen SQL instance'ınızın üzerine sqğ tıklayarak Properties > Security üzerinden Server authentication seçeneklerinden SQL Server and Windows Authentication mode seçeneğini seçin.
4. Security > Logins > sa üzerine sağ tıklayarak Properties > Status sayfasını açın.
5. Login seçeneğini Enabled olarak ayarlayın.
6. Password'ü 123456 olarak ayarlayın. Enforce password policy seçeneğini kapatın.
7. SQL Server 2019 Configuration Manager üzerinden SQL Servers sayfasında SQL Server (MSSQLSERVER)'a sağ tıklayıp yeniden başlatın.

Bu adımları doğru bir şekilde takip ettiyseniz MS-SQL kurulumunuzu başarıyla tamamlamışsınız demektir.
    
## Visual Studio Code

[Bu linkten](https://code.visualstudio.com/) VS Code'u bilgisayarınıza kurun.

## NodeJS

[Bu linkten](https://nodejs.org/gl/blog/release/v14.17.5/) bilgisayarınıza uygun Node v14.17.5 (LTS) indirip, kurulumunu yapın.

Bu komutu bilgisayarınızın konsolunda çalıştırdığınızda şu çıktıyı almalısınız.

```cmd
~$ node -v
v14.17.5
```
