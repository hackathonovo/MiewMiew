using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

namespace MiewMiew.Models
{
	public partial class HackatonIn2Context : DbContext
	{
		public virtual DbSet<AkcijaSpasavanje> AkcijaSpasavanje { get; set; }
		public virtual DbSet<AspNetRoleClaims> AspNetRoleClaims { get; set; }
		public virtual DbSet<AspNetRoles> AspNetRoles { get; set; }
		public virtual DbSet<AspNetUserClaims> AspNetUserClaims { get; set; }
		public virtual DbSet<AspNetUserLogins> AspNetUserLogins { get; set; }
		public virtual DbSet<AspNetUserRoles> AspNetUserRoles { get; set; }
		public virtual DbSet<AspNetUserTokens> AspNetUserTokens { get; set; }
		public virtual DbSet<AspNetUsers> AspNetUsers { get; set; }
		public virtual DbSet<Dostupan> Dostupan { get; set; }
		public virtual DbSet<KompetencijeKorisnika> KompetencijeKorisnika { get; set; }
		public virtual DbSet<Nedostupan> Nedostupan { get; set; }
		public virtual DbSet<Poruka> Poruka { get; set; }
		public virtual DbSet<Socket> Socket { get; set; }
		public virtual DbSet<SocketConnection> SocketConnection { get; set; }
		public virtual DbSet<Specijalnosti> Specijalnosti { get; set; }
		public virtual DbSet<SpecijalnostiVrstaSpasavanja> SpecijalnostiVrstaSpasavanja { get; set; }
		public virtual DbSet<Sudionici> Sudionici { get; set; }
		public virtual DbSet<VjestineKorisnika> VjestineKorisnika { get; set; }
		public virtual DbSet<VrstaSpasavanja> VrstaSpasavanja { get; set; }


		public HackatonIn2Context(DbContextOptions<HackatonIn2Context> options)
			: base(options)
		{

		}



		protected override void OnModelCreating(ModelBuilder modelBuilder)
		{
			modelBuilder.Entity<AkcijaSpasavanje>(entity =>
			{
				entity.Property(e => e.Id).HasColumnName("id");

				entity.Property(e => e.Naziv).HasMaxLength(50);

				entity.Property(e => e.NazivLokacije).HasMaxLength(100);

				entity.Property(e => e.Opis).HasMaxLength(550);

				entity.Property(e => e.VoditeljId).HasMaxLength(450);

				entity.Property(e => e.Vrijeme).HasColumnType("datetime");

				entity.HasOne(d => d.Voditelj)
					.WithMany(p => p.AkcijaSpasavanje)
					.HasForeignKey(d => d.VoditeljId)
					.HasConstraintName("FK_AkcijaSpasavanje_AspNetUsers_Id");

				entity.HasOne(d => d.VrstaSpasavanja)
					.WithMany(p => p.AkcijaSpasavanje)
					.HasForeignKey(d => d.VrstaSpasavanjaId)
					.HasConstraintName("FK_AkcijaSpasavanje_VrstaSpasavanja_id");
			});

			modelBuilder.Entity<AspNetRoleClaims>(entity =>
			{
				entity.HasIndex(e => e.RoleId)
					.HasName("IX_AspNetRoleClaims_RoleId");

				entity.Property(e => e.RoleId)
					.IsRequired()
					.HasMaxLength(450);

				entity.HasOne(d => d.Role)
					.WithMany(p => p.AspNetRoleClaims)
					.HasForeignKey(d => d.RoleId);
			});

			modelBuilder.Entity<AspNetRoles>(entity =>
			{
				entity.HasIndex(e => e.NormalizedName)
					.HasName("RoleNameIndex");

				entity.Property(e => e.Id).HasMaxLength(450);

				entity.Property(e => e.Name).HasMaxLength(256);

				entity.Property(e => e.NormalizedName).HasMaxLength(256);
			});

			modelBuilder.Entity<AspNetUserClaims>(entity =>
			{
				entity.HasIndex(e => e.UserId)
					.HasName("IX_AspNetUserClaims_UserId");

				entity.Property(e => e.UserId)
					.IsRequired()
					.HasMaxLength(450);

				entity.HasOne(d => d.User)
					.WithMany(p => p.AspNetUserClaims)
					.HasForeignKey(d => d.UserId);
			});

			modelBuilder.Entity<AspNetUserLogins>(entity =>
			{
				entity.HasKey(e => new { e.LoginProvider, e.ProviderKey })
					.HasName("PK_AspNetUserLogins");

				entity.HasIndex(e => e.UserId)
					.HasName("IX_AspNetUserLogins_UserId");

				entity.Property(e => e.LoginProvider).HasMaxLength(450);

				entity.Property(e => e.ProviderKey).HasMaxLength(450);

				entity.Property(e => e.UserId)
					.IsRequired()
					.HasMaxLength(450);

				entity.HasOne(d => d.User)
					.WithMany(p => p.AspNetUserLogins)
					.HasForeignKey(d => d.UserId);
			});

			modelBuilder.Entity<AspNetUserRoles>(entity =>
			{
				entity.HasKey(e => new { e.UserId, e.RoleId })
					.HasName("PK_AspNetUserRoles");

				entity.HasIndex(e => e.RoleId)
					.HasName("IX_AspNetUserRoles_RoleId");

				entity.HasIndex(e => e.UserId)
					.HasName("IX_AspNetUserRoles_UserId");

				entity.Property(e => e.UserId).HasMaxLength(450);

				entity.Property(e => e.RoleId).HasMaxLength(450);

				entity.HasOne(d => d.Role)
					.WithMany(p => p.AspNetUserRoles)
					.HasForeignKey(d => d.RoleId);

				entity.HasOne(d => d.User)
					.WithMany(p => p.AspNetUserRoles)
					.HasForeignKey(d => d.UserId);
			});

			modelBuilder.Entity<AspNetUserTokens>(entity =>
			{
				entity.HasKey(e => new { e.UserId, e.LoginProvider, e.Name })
					.HasName("PK_AspNetUserTokens");

				entity.Property(e => e.UserId).HasMaxLength(450);

				entity.Property(e => e.LoginProvider).HasMaxLength(450);

				entity.Property(e => e.Name).HasMaxLength(450);
			});

			modelBuilder.Entity<AspNetUsers>(entity =>
			{
				entity.HasIndex(e => e.NormalizedEmail)
					.HasName("EmailIndex");

				entity.HasIndex(e => e.NormalizedUserName)
					.HasName("UserNameIndex")
					.IsUnique();

				entity.Property(e => e.Id).HasMaxLength(450);

				entity.Property(e => e.Created).HasColumnType("datetime");

				entity.Property(e => e.Email).HasMaxLength(256);

				entity.Property(e => e.Ime).HasMaxLength(50);

				entity.Property(e => e.Latitude).HasColumnType("decimal");

				entity.Property(e => e.Longitude).HasColumnType("decimal");

				entity.Property(e => e.NormalizedEmail).HasMaxLength(256);

				entity.Property(e => e.NormalizedUserName)
					.IsRequired()
					.HasMaxLength(256);

				entity.Property(e => e.Prezime).HasMaxLength(50);

				entity.Property(e => e.Salt).HasMaxLength(500);

				entity.Property(e => e.UserName).HasMaxLength(256);
			});

			modelBuilder.Entity<Dostupan>(entity =>
			{
				entity.Property(e => e.KorisnikId).HasMaxLength(450);

				entity.HasOne(d => d.Korisnik)
					.WithMany(p => p.Dostupan)
					.HasForeignKey(d => d.KorisnikId)
					.HasConstraintName("FK_Dostupan_AspNetUsers_Id");
			});

			modelBuilder.Entity<KompetencijeKorisnika>(entity =>
			{
				entity.Property(e => e.Id).HasColumnName("id");

				entity.Property(e => e.Kompetencija).HasColumnName("kompetencija");

				entity.Property(e => e.Korisnik)
					.HasColumnName("korisnik")
					.HasMaxLength(450);
			});

			modelBuilder.Entity<Nedostupan>(entity =>
			{
				entity.Property(e => e.Do).HasColumnType("datetime");

				entity.Property(e => e.KorisnikId).HasMaxLength(450);

				entity.Property(e => e.Od).HasColumnType("datetime");

				entity.HasOne(d => d.Korisnik)
					.WithMany(p => p.Nedostupan)
					.HasForeignKey(d => d.KorisnikId)
					.HasConstraintName("FK_Nedostupan_AspNetUsers_Id");
			});

			modelBuilder.Entity<Poruka>(entity =>
			{
				entity.Property(e => e.Poruka1)
					.HasColumnName("Poruka")
					.HasMaxLength(450);

				entity.Property(e => e.PrimaKorisnikId).HasMaxLength(450);

				entity.Property(e => e.SaljeKorisnikId).HasMaxLength(450);

				entity.Property(e => e.Vrijeme).HasColumnType("datetime");

				entity.HasOne(d => d.Akcija)
					.WithMany(p => p.Poruka)
					.HasForeignKey(d => d.AkcijaId)
					.HasConstraintName("FK_Poruka_AkcijaSpasavanje_id");

				entity.HasOne(d => d.PrimaKorisnik)
					.WithMany(p => p.PorukaPrimaKorisnik)
					.HasForeignKey(d => d.PrimaKorisnikId)
					.HasConstraintName("FK_Poruka_AspNetUsers_Id2");

				entity.HasOne(d => d.SaljeKorisnik)
					.WithMany(p => p.PorukaSaljeKorisnik)
					.HasForeignKey(d => d.SaljeKorisnikId)
					.HasConstraintName("FK_Poruka_AspNetUsers_Id");
			});

			modelBuilder.Entity<Socket>(entity =>
			{
				entity.Property(e => e.Message).HasColumnType("varchar(50)");

				entity.Property(e => e.UserId).HasMaxLength(450);

				entity.HasOne(d => d.User)
					.WithMany(p => p.Socket)
					.HasForeignKey(d => d.UserId)
					.HasConstraintName("FK_Socket_UserId");
			});

			modelBuilder.Entity<SocketConnection>(entity =>
			{
				entity.Property(e => e.SocketId)
					.IsRequired()
					.HasMaxLength(50);

				entity.Property(e => e.UserId).HasMaxLength(450);

				entity.HasOne(d => d.User)
					.WithMany(p => p.SocketConnection)
					.HasForeignKey(d => d.UserId)
					.HasConstraintName("FK_SocketConnection_UserId");
			});

			modelBuilder.Entity<Specijalnosti>(entity =>
			{
				entity.Property(e => e.Naziv).HasMaxLength(50);
			});

			modelBuilder.Entity<SpecijalnostiVrstaSpasavanja>(entity =>
			{
				entity.HasOne(d => d.Specijalnosti)
					.WithMany(p => p.SpecijalnostiVrstaSpasavanja)
					.HasForeignKey(d => d.SpecijalnostiId)
					.HasConstraintName("FK_SpecijalnostiVrstaSpasavanja_Specijalnosti_Id");

				entity.HasOne(d => d.VrstaSpasavanja)
					.WithMany(p => p.SpecijalnostiVrstaSpasavanja)
					.HasForeignKey(d => d.VrstaSpasavanjaId)
					.HasConstraintName("FK_SpecijalnostiVrstaSpasavanja_VrstaSpasavanja_id");
			});

			modelBuilder.Entity<Sudionici>(entity =>
			{
				entity.HasKey(e => new { e.KorisnikId, e.AkcijaSpasavanjaId })
					.HasName("PK_Sudionici");

				entity.Property(e => e.KorisnikId).HasMaxLength(450);

				entity.HasOne(d => d.AkcijaSpasavanja)
					.WithMany(p => p.Sudionici)
					.HasForeignKey(d => d.AkcijaSpasavanjaId)
					.OnDelete(DeleteBehavior.Restrict)
					.HasConstraintName("FK_Sudionici_AkcijaSpasavanje_id");

				entity.HasOne(d => d.Korisnik)
					.WithMany(p => p.Sudionici)
					.HasForeignKey(d => d.KorisnikId)
					.OnDelete(DeleteBehavior.Restrict)
					.HasConstraintName("FK_Sudionici_AspNetUsers_Id");
			});

			modelBuilder.Entity<VjestineKorisnika>(entity =>
			{
				entity.Property(e => e.KorisnikId).HasMaxLength(450);

				entity.HasOne(d => d.Korisnik)
					.WithMany(p => p.VjestineKorisnika)
					.HasForeignKey(d => d.KorisnikId)
					.HasConstraintName("FK_VjestineKorisnika_AspNetUsers_Id");

				entity.HasOne(d => d.Specijalnost)
					.WithMany(p => p.VjestineKorisnika)
					.HasForeignKey(d => d.SpecijalnostId)
					.HasConstraintName("FK_VjestineKorisnika_Specijalnosti_Id");
			});

			modelBuilder.Entity<VrstaSpasavanja>(entity =>
			{
				entity.Property(e => e.Id).HasColumnName("id");

				entity.Property(e => e.Vrsta)
					.IsRequired()
					.HasMaxLength(50);
			});
		}
	}
}