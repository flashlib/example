using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;

namespace BigShapes
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class Form1 : System.Windows.Forms.Form
	{
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;
		private Point rectangleTopLeft = new Point(0, 0);
		private Size rectangleSize = new Size(200,200);
		private Point ellipseTopLeft = new Point(50, 200);
		private Size ellipseSize = new Size(200, 150);
		private Pen bluePen = new Pen(Color.Blue, 3);
		private Pen redPen = new Pen(Color.Red, 2);

		protected override void OnPaint( PaintEventArgs e )
		{
			base.OnPaint(e);
			Graphics dc = e.Graphics;
			Size scrollOffset = new Size(this.AutoScrollPosition);
			if (e.ClipRectangle.Top+scrollOffset.Width < 350 || 
				e.ClipRectangle.Left+scrollOffset.Height < 250)
			{
				Rectangle rectangleArea = new Rectangle
					(rectangleTopLeft+scrollOffset, rectangleSize);
				Rectangle ellipseArea = new Rectangle
					(ellipseTopLeft+scrollOffset, ellipseSize);
				dc.DrawRectangle(bluePen, rectangleArea);
				dc.DrawEllipse(redPen, ellipseArea);
			}

		}

		public Form1()
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();
			this.BackColor = Color.White;
		
			this.Size = new System.Drawing.Size(300,300);
			this.Text = "Scroll Shapes Correct";
		

         this.AutoScrollMinSize = new Size(250, 350);

			//
			// TODO: Add any constructor code after InitializeComponent call
			//
		}

		/// <summary>
		/// Clean up any resources being used.
		/// </summary>
		protected override void Dispose( bool disposing )
		{
			if( disposing )
			{
				if (components != null) 
				{
					components.Dispose();
				}
			}
			base.Dispose( disposing );
		}

		#region Windows Form Designer generated code
		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent()
		{
			// 
			// Form1
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.ClientSize = new System.Drawing.Size(292, 273);
			this.Name = "Form1";
			this.Text = "BigShapes";

		}
		#endregion

		/// <summary>
		/// The main entry point for the application.
		/// </summary>
		[STAThread]
		static void Main() 
		{
			Application.Run(new Form1());
		}
	}
}
