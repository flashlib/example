
#include <qlabel.h>
#include <qbitmap.h>
#include <qapplication.h>
#include <qlayout.h>
#include <qtextcodec.h>
#include <qfont.h>

#define cb_width  32
#define cb_height 32

//光标形状
static unsigned char cb_bits[] = {		// cursor bitmap
   0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0xf8, 0x0f, 0x00,
   0x00, 0x06, 0x30, 0x00, 0x80, 0x01, 0xc0, 0x00, 0x40, 0x00, 0x00, 0x01,
   0x20, 0x00, 0x00, 0x02, 0x10, 0x00, 0x00, 0x04, 0x08, 0x3e, 0x3e, 0x08,
   0x08, 0x03, 0xe0, 0x08, 0xc4, 0x00, 0x00, 0x11, 0x04, 0x1e, 0x78, 0x10,
   0x02, 0x0c, 0x30, 0x20, 0x02, 0x40, 0x00, 0x20, 0x02, 0x40, 0x00, 0x20,
   0x02, 0x40, 0x00, 0x20, 0x02, 0x20, 0x04, 0x20, 0x02, 0x20, 0x04, 0x20,
   0x02, 0x10, 0x08, 0x20, 0x02, 0x08, 0x08, 0x20, 0x02, 0xf0, 0x07, 0x20,
   0x04, 0x00, 0x00, 0x10, 0x04, 0x00, 0x00, 0x10, 0x08, 0x00, 0xc0, 0x08,
   0x08, 0x3c, 0x30, 0x08, 0x10, 0xe6, 0x19, 0x04, 0x20, 0x00, 0x0f, 0x02,
   0x40, 0x00, 0x00, 0x01, 0x80, 0x01, 0xc0, 0x00, 0x00, 0x06, 0x30, 0x00,
   0x00, 0xf8, 0x0f, 0x00, 0x00, 0x00, 0x00, 0x00};

#define cm_width  32
#define cm_height 32

//光标掩码形状
static unsigned char cm_bits[] = {		// cursor bitmap mask
   0x00, 0x00, 0x00, 0x00, 0x00, 0xf8, 0x1f, 0x00, 0x00, 0xfe, 0x3f, 0x00,
   0x80, 0x07, 0xf0, 0x00, 0xc0, 0x01, 0xc0, 0x01, 0x60, 0x00, 0x00, 0x03,
   0x30, 0x00, 0x00, 0x06, 0x18, 0x00, 0x00, 0x0c, 0x0c, 0x3e, 0x3e, 0x18,
   0x0e, 0x03, 0xe0, 0x18, 0xc6, 0x00, 0x00, 0x31, 0x07, 0x1e, 0x78, 0x30,
   0x03, 0x0c, 0x30, 0x60, 0x03, 0x40, 0x00, 0x60, 0x03, 0x40, 0x00, 0x60,
   0x03, 0x40, 0x00, 0x60, 0x03, 0x20, 0x04, 0x60, 0x03, 0x20, 0x04, 0x60,
   0x03, 0x10, 0x08, 0x60, 0x03, 0x08, 0x08, 0x60, 0x03, 0xf0, 0x07, 0x60,
   0x06, 0x00, 0x00, 0x30, 0x06, 0x00, 0x00, 0x30, 0x0c, 0x00, 0xc0, 0x18,
   0x0c, 0x3c, 0x30, 0x18, 0x18, 0xe6, 0x19, 0x0c, 0x30, 0x00, 0x0f, 0x06,
   0x60, 0x00, 0x00, 0x03, 0xc0, 0x01, 0xc0, 0x01, 0x80, 0x07, 0xf0, 0x00,
   0x00, 0xfe, 0x3f, 0x00, 0x00, 0xf8, 0x0f, 0x00};


class CursorView : public QWidget
{
public:
	CursorView();
};


CursorView::CursorView()
{
	static struct {
		QCursorShape	shape;					
		const char*	name;
    	} list[] = {
		{ ArrowCursor,		"arrowCursor" },
		{ UpArrowCursor,	"upArrowCursor" },
		{ CrossCursor,		"crossCursor" },
		{ WaitCursor,		"waitCursor" },
		{ IbeamCursor,		"ibeamCursor" },
		{ SizeVerCursor,	"sizeVerCursor" },
		{ SizeHorCursor,	"sizeHorCursor" },
		{ SizeBDiagCursor,	"sizeBDiagCursor" },
		{ SizeFDiagCursor,	"sizeFDiagCursor" },
		{ SizeAllCursor,	"sizeAllCursor" },
		{ BlankCursor,		"blankCursor" },
		{ SplitVCursor,		"splitVCursor" },
		{ SplitHCursor,		"splitHCursor" },
		{ PointingHandCursor,	"pointingHandCursor" },
		{ ForbiddenCursor,	"forbiddenCursor" },
		{ BitmapCursor,		"" }
    	};

	//设置窗口标题
	setCaption( QObject::tr("光标演示") );

	//建立布局
	QGridLayout* grid = new QGridLayout( this, 5, 4, 20 );
	QLabel *label;

	int i=0;
	for ( int y=0; y<4; y++ ) {
		for ( int x=0; x<4; x++ ) {
	    		if ( list[i].shape == BitmapCursor ) break;
	    		label = new QLabel( this );
	    		label->setCursor( QCursor( list[i].shape ) );
	    		label->setText( list[i].name );
	    		label->setAlignment( AlignCenter );
	    		label->setFrameStyle( QFrame::Box | QFrame::Raised );
	    		grid->addWidget( label, x, y );
	    		i++;
		}
    	}

	//建立位图光标
	QBitmap cb( cb_width, cb_height, cb_bits, TRUE );
	QBitmap cm( cm_width, cm_height, cm_bits, TRUE );
	QCursor custom( cb, cm );

	label = new QLabel( this );
	label->setCursor( custom );
	label->setText( tr("我的位图光标") );
	label->setAlignment( AlignCenter );
	label->setFrameStyle( QFrame::Box | QFrame::Sunken );
	grid->addMultiCellWidget( label, 4, 4, 0, 3 );

}


int main( int argc, char **argv )
{
	QApplication a( argc, argv );
	a.setFont(QFont("Times", 16, QFont::Bold));
	a.setDefaultCodec( QTextCodec::codecForName("GBK") );
	CursorView   v;
	a.setMainWidget( &v );
	v.show();
	return a.exec();
}
