package blackboard.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.blackboard.developer.apisample.api.B2ApiSample;
import com.blackboard.developer.apisample.impl.B2ApiSampleImpl;
import blackboard.platform.context.*;
import blackboard.data.course.*;
import blackboard.data.user.*;
import java.util.*;

public final class getCourseList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fbbNG_005fgenericPage_0026_005ftitle;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fbbNG_005fpageHeader;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fbbNG_005fbreadcrumbBar;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fbbNG_005fbreadcrumb;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fbbNG_005fpageTitleBar;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fbbNG_005fgenericPage_0026_005ftitle = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fbbNG_005fpageHeader = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fbbNG_005fbreadcrumbBar = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fbbNG_005fbreadcrumb = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fbbNG_005fpageTitleBar = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fbbNG_005fgenericPage_0026_005ftitle.release();
    _005fjspx_005ftagPool_005fbbNG_005fpageHeader.release();
    _005fjspx_005ftagPool_005fbbNG_005fbreadcrumbBar.release();
    _005fjspx_005ftagPool_005fbbNG_005fbreadcrumb.release();
    _005fjspx_005ftagPool_005fbbNG_005fpageTitleBar.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n\n");
      //  bbNG:genericPage
      blackboard.servlet.tags.ngui.GenericPageTag _jspx_th_bbNG_005fgenericPage_005f0 = (blackboard.servlet.tags.ngui.GenericPageTag) _005fjspx_005ftagPool_005fbbNG_005fgenericPage_0026_005ftitle.get(blackboard.servlet.tags.ngui.GenericPageTag.class);
      _jspx_th_bbNG_005fgenericPage_005f0.setPageContext(_jspx_page_context);
      _jspx_th_bbNG_005fgenericPage_005f0.setParent(null);
      // /getCourseList.jsp(14,0) name = title type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_bbNG_005fgenericPage_005f0.setTitle("Course Listing");
      int _jspx_eval_bbNG_005fgenericPage_005f0 = _jspx_th_bbNG_005fgenericPage_005f0.doStartTag();
      if (_jspx_eval_bbNG_005fgenericPage_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        blackboard.platform.context.Context bbContext = null;
        if (_jspx_eval_bbNG_005fgenericPage_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_bbNG_005fgenericPage_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_bbNG_005fgenericPage_005f0.doInitBody();
        }
        bbContext = (blackboard.platform.context.Context) _jspx_page_context.findAttribute("bbContext");
        do {
          if (_jspx_meth_bbNG_005fpageHeader_005f0(_jspx_th_bbNG_005fgenericPage_005f0, _jspx_page_context))
            return;

	try {
		Context ctx = ContextManagerFactory.getInstance().getContext();
		B2ApiSample apiSample = new B2ApiSampleImpl();
		User user = ctx.getUser();
		
		
          out.write("<h2>Course List for User ");
          out.print(user.getGivenName());
          out.print(user.getFamilyName() );
          out.write("</h2><br />\n\t\t");

		List<Course> courseListing = apiSample.getCourseListForUser(user.getId());
		ListIterator<Course> courseIt = courseListing.listIterator();
		
		while(courseIt.hasNext()) {
			Course course = courseIt.next();
			String title = course.getDisplayTitle();
			String id = course.getId().toExternalString();
			String buid = course.getBatchUid();
			
          out.write("<h2>");
          out.print(title);
          out.write("</h2><br />\n\t\t\tUser Id: ");
          out.print(id);
          out.write("<br />\n\t\t\tBatchUid: ");
          out.print(buid);
          out.write("<br /><br />\n\t\t\t");

		}
	} catch(Exception e) {
		
          out.print(e.getMessage() );

	}
	
          int evalDoAfterBody = _jspx_th_bbNG_005fgenericPage_005f0.doAfterBody();
          bbContext = (blackboard.platform.context.Context) _jspx_page_context.findAttribute("bbContext");
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_bbNG_005fgenericPage_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_bbNG_005fgenericPage_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fbbNG_005fgenericPage_0026_005ftitle.reuse(_jspx_th_bbNG_005fgenericPage_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fbbNG_005fgenericPage_0026_005ftitle.reuse(_jspx_th_bbNG_005fgenericPage_005f0);
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_bbNG_005fpageHeader_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_bbNG_005fgenericPage_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bbNG:pageHeader
    blackboard.servlet.tags.ngui.PageHeaderTag _jspx_th_bbNG_005fpageHeader_005f0 = (blackboard.servlet.tags.ngui.PageHeaderTag) _005fjspx_005ftagPool_005fbbNG_005fpageHeader.get(blackboard.servlet.tags.ngui.PageHeaderTag.class);
    _jspx_th_bbNG_005fpageHeader_005f0.setPageContext(_jspx_page_context);
    _jspx_th_bbNG_005fpageHeader_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_bbNG_005fgenericPage_005f0);
    int _jspx_eval_bbNG_005fpageHeader_005f0 = _jspx_th_bbNG_005fpageHeader_005f0.doStartTag();
    if (_jspx_eval_bbNG_005fpageHeader_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_bbNG_005fpageHeader_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_bbNG_005fpageHeader_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_bbNG_005fpageHeader_005f0.doInitBody();
      }
      do {
        if (_jspx_meth_bbNG_005fbreadcrumbBar_005f0(_jspx_th_bbNG_005fpageHeader_005f0, _jspx_page_context))
          return true;
        if (_jspx_meth_bbNG_005fpageTitleBar_005f0(_jspx_th_bbNG_005fpageHeader_005f0, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_bbNG_005fpageHeader_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_bbNG_005fpageHeader_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_bbNG_005fpageHeader_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbbNG_005fpageHeader.reuse(_jspx_th_bbNG_005fpageHeader_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fbbNG_005fpageHeader.reuse(_jspx_th_bbNG_005fpageHeader_005f0);
    return false;
  }

  private boolean _jspx_meth_bbNG_005fbreadcrumbBar_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_bbNG_005fpageHeader_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bbNG:breadcrumbBar
    blackboard.servlet.tags.ngui.BreadcrumbBarTag _jspx_th_bbNG_005fbreadcrumbBar_005f0 = (blackboard.servlet.tags.ngui.BreadcrumbBarTag) _005fjspx_005ftagPool_005fbbNG_005fbreadcrumbBar.get(blackboard.servlet.tags.ngui.BreadcrumbBarTag.class);
    _jspx_th_bbNG_005fbreadcrumbBar_005f0.setPageContext(_jspx_page_context);
    _jspx_th_bbNG_005fbreadcrumbBar_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_bbNG_005fpageHeader_005f0);
    int _jspx_eval_bbNG_005fbreadcrumbBar_005f0 = _jspx_th_bbNG_005fbreadcrumbBar_005f0.doStartTag();
    if (_jspx_eval_bbNG_005fbreadcrumbBar_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_bbNG_005fbreadcrumbBar_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_bbNG_005fbreadcrumbBar_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_bbNG_005fbreadcrumbBar_005f0.doInitBody();
      }
      do {
        if (_jspx_meth_bbNG_005fbreadcrumb_005f0(_jspx_th_bbNG_005fbreadcrumbBar_005f0, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_bbNG_005fbreadcrumbBar_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_bbNG_005fbreadcrumbBar_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_bbNG_005fbreadcrumbBar_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbbNG_005fbreadcrumbBar.reuse(_jspx_th_bbNG_005fbreadcrumbBar_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fbbNG_005fbreadcrumbBar.reuse(_jspx_th_bbNG_005fbreadcrumbBar_005f0);
    return false;
  }

  private boolean _jspx_meth_bbNG_005fbreadcrumb_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_bbNG_005fbreadcrumbBar_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bbNG:breadcrumb
    blackboard.servlet.tags.ngui.BreadcrumbTag _jspx_th_bbNG_005fbreadcrumb_005f0 = (blackboard.servlet.tags.ngui.BreadcrumbTag) _005fjspx_005ftagPool_005fbbNG_005fbreadcrumb.get(blackboard.servlet.tags.ngui.BreadcrumbTag.class);
    _jspx_th_bbNG_005fbreadcrumb_005f0.setPageContext(_jspx_page_context);
    _jspx_th_bbNG_005fbreadcrumb_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_bbNG_005fbreadcrumbBar_005f0);
    int _jspx_eval_bbNG_005fbreadcrumb_005f0 = _jspx_th_bbNG_005fbreadcrumb_005f0.doStartTag();
    if (_jspx_eval_bbNG_005fbreadcrumb_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_bbNG_005fbreadcrumb_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_bbNG_005fbreadcrumb_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_bbNG_005fbreadcrumb_005f0.doInitBody();
      }
      do {
        out.write("Course Listing");
        int evalDoAfterBody = _jspx_th_bbNG_005fbreadcrumb_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_bbNG_005fbreadcrumb_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_bbNG_005fbreadcrumb_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbbNG_005fbreadcrumb.reuse(_jspx_th_bbNG_005fbreadcrumb_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fbbNG_005fbreadcrumb.reuse(_jspx_th_bbNG_005fbreadcrumb_005f0);
    return false;
  }

  private boolean _jspx_meth_bbNG_005fpageTitleBar_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_bbNG_005fpageHeader_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bbNG:pageTitleBar
    blackboard.servlet.tags.ngui.PageTitleBarTag _jspx_th_bbNG_005fpageTitleBar_005f0 = (blackboard.servlet.tags.ngui.PageTitleBarTag) _005fjspx_005ftagPool_005fbbNG_005fpageTitleBar.get(blackboard.servlet.tags.ngui.PageTitleBarTag.class);
    _jspx_th_bbNG_005fpageTitleBar_005f0.setPageContext(_jspx_page_context);
    _jspx_th_bbNG_005fpageTitleBar_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_bbNG_005fpageHeader_005f0);
    int _jspx_eval_bbNG_005fpageTitleBar_005f0 = _jspx_th_bbNG_005fpageTitleBar_005f0.doStartTag();
    if (_jspx_eval_bbNG_005fpageTitleBar_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_bbNG_005fpageTitleBar_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_bbNG_005fpageTitleBar_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_bbNG_005fpageTitleBar_005f0.doInitBody();
      }
      do {
        out.write("Course Listing");
        int evalDoAfterBody = _jspx_th_bbNG_005fpageTitleBar_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_bbNG_005fpageTitleBar_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_bbNG_005fpageTitleBar_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fbbNG_005fpageTitleBar.reuse(_jspx_th_bbNG_005fpageTitleBar_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fbbNG_005fpageTitleBar.reuse(_jspx_th_bbNG_005fpageTitleBar_005f0);
    return false;
  }
}
